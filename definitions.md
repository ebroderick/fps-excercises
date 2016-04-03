- **algebra** - abstract set of operations along with a set of laws or properties we assume to be
    true. in mathematical sense, one or more sets, together with a collection of functions
    operating on objects of these sets, and a set of axioms (statements assumed true from
    which we can derive other theorems that must also be true). From chp 7, sets are types
    like _Par[A]_ and _List[Par[A]]_, functions are operations like _map2_, _unit_, _sequence_

- **applicative functors** - abstraction with _map2_ and _unit_ as primitives. Since map2 can be implemented using
    flatMap, all monads are applicative functors. Applicative computations have a fixed structure - the result of one
    computation cannot influence the next one (as the case is with the option monad, for example) - they simply sequence
    events. Along those lines, applicative constructs _context-free_ computations, whereas monad allows for
    _context sensitivity_. Applicative functors _compose_, but monads (in general) do not.
    - 2 sets of minimum primitives for an applicative
        - _unit_ and _map2_
        - _unit_ and _apply_ (`apply[A, B](fab: F[A => B])(fa: F[A]): F[B]` - map2 can be implemented in terms of
        apply and unit)

- **compose/andThen** - f compose g = f(g(_), f andThen g = g(f(_))

    ```scala
    scala> val f1 = (i: Int) => { println("f1"); i + 2 }
    f1: Int => Int = <function1>

    scala> val f2 = (i: Int) => { println("f2"); i + 3 }
    f2: Int => Int = <function1>

    scala> val compose = f1.compose(f2)
    compose: Int => Int = <function1>

    scala> val andThen = f1.andThen(f2)
    andThen: Int => Int = <function1>

    scala> compose(1)
    f2
    f1
    res1: Int = 6

    scala> andThen(1)
    f1
    f2
    res2: Int = 6
    ```

- **effects** - types like Par, Option, List, Parser, Gen are informally called _effects_ in FP, since they
    "augment ordinary values with extra capabilities." e.g. Option as the possibility of failure. If an effect is associated
    with a monad or applicative instance, they are sometimes called _monadic effects_ or _applicative effects_.

- **endofunction** - function where argument type and return type are the same. endo = within, "endofunction's codomain 
is within its domain."

- **foldable** - a data type that implements:

    ```scala
    trait Foldable[F[_]] {
        def foldRight[A,B](as: F[A])(z: B)(f: (A,B) => B): B
        def foldLeft[A,B](as: F[A])(z: B)(f: (B,A) => B): B
        def foldMap[A,B](as: F[A])(f: A => B)(mb: Monoid[B]): B
        def concatenate[A](as: F[A])(m: Monoid[A]): A =
            foldLeft(as)(m.zero)(m.op)
    }
    ```

- **functor** - a data type that implements map. list, option, or F below are functors

    ```scala
    trait Functor[F[_]] {
        def map[A, B](fa: F[A])(f: A => B): F[B]
    }
    ```

- **higher-kinded type** - values/functions : types :: types : kinds. analogous to "higher-order type constructor." 
written as F[_] where the _ indicates that F is not a type but a type constructor. Kinds track how many type arguments a type constructor takes, whether it's
co or contravariant in those arguments, and what the kinds of those arguments are.

    ```scala
    trait T[F[_]] {
        def doSomething[A](c: F[A]): A
    }
    class TList extends T[List] {
        override def doSomething[A](c: List[A]): A = c.head
    }
    class TOption extends T[Option] {
        override def doSomething[A](c: Option[A]): A = c.get
    }
    ```
    
- **kleisli arrows** - monadic functions of types like ```A => F[B]```. can be composed with one another: 

    ```scala 
    def compose[A,B,C](f: A => F[B], g: B => F[C]): A => F[C]
    ```

- **memoization** - ensures thunk is only evaluated once when forced for the first time. example:

    ```scala
    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
        lazy val head = hd
        lazy val tail = tl
        Cons(() => head, () => tail)
    }
    ```
    
- **monad** - has unit and flapMap primatives. all monads are functors, but not all functors are monads.
    
    ```scala    
    trait Monad[F[_]] extends Functor[F] {
        def unit[A](a: A): F[A]
        def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    
        def map[A, B](fa: F[A])(f: A => B): F[B] =
            flatMap(fa)(a => unit(f(a)))
    
        def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
            flatMap(fa)(a => map(fb)(b => f(a, b)))
    }
    ```
    - associative law: 
        
        ```scala
        x.flatMap(f).flatMap(g) == x.flatMap(a => f(a).flatMap(g))
        //or with compose instead of flatMap
        compose(compose(f, g), h) == compose(f, compose(g, h))
        ```
        
    - identity law:
    
        ```scala
        flatMap(x)(unit) == f
        flatMap(unit(y))(f) == f(y)
        //or with compose instead of flatMap
        compose(f, unit) == f
        compose(unit, f) == f
        ```
        
    - actually 3 minimal sets of primitive Monad combinators:
        - _unit_ and _flatMap_
        - _unit_ and _compose_ (compose is ```(A => F[B], B => F[C]) => A => F[C]```)
        - _unit_, _map_, and _join_ (join is ```F[F[A]] => F[A]```)
    
- **monoid** - algebra that conforms to "monoid laws" of associativity and identity. examples are string concatenation with "" as 
the identity, addition with 0 as the identity, multiplication with 1 as the identity, and && and || with identity 
elements _true_ and _false_. monoid consists of:
    - Some type A
    - An associative binary operation, e.g +/addition
    - A value zero: A that is an identity for that operation, e.g. 4 * 1 = 4 where 1 is the identity

- **monoid homomorphism** - function that preserves the monoid structure (homo = same, morphe = shape)

    ```scala
    "foo".length + "bar".length == ("foo" + "bar").length
    Monoid.op(f(x), f(y)) == f(Monoid.op(x, y))
    ```

- **partial type application** - example issue: `Monad[F[_]]` has a type constructor of one argument, but we want to create
    a monad instance with `State[S, A]` which has two type arguments. Cannot just say `Monad[State]`. If we nail down `S`,
    we can have a type that only takes one type parameter and thus can be used with the monad type constructor.
    > We’d like to be able to partially apply State to where the S type argument is fixed to be some concrete type.
    > This is much like how we might partially apply a function, except at the type level.
    For example, just use a type alias:

    ```scala
    type IntState[A] = State[Int, A] //nail down S to Int
    ``
    Now can create monads using `Monad[IntState]` but having to create a type alias for each state type that
    needs to be supported is very repetitive. Instead, can use "something similar to lambda syntax at the type level":

    ```scala
    object IntStateMonad extends
        Monad[({type IntState[A] = State[Int, A]})#IntState] {
        ...
    }
    ```
    This is declaring an anonymous type within parentheses, which has the type alias IntState as one of its members. Access
    to the type alias is done through the `#` operator, which is like `.` but for types. This is often called a
    _type lambda_ in Scala. The name of the type alias is arbitrary:

    ```scala
    def stateMonad[S] = new Monad[({type f[x] = State[S,x]})#f] {
    ...
    }
    ```

- **product**
    - monoid example: if A and B are monoids, the tuple type (A, B) is their product and is also a monoid.
 
- **thunk** - unevaluated form of an expression. "force" the thunk to evaluate. ex type: _() => A_.
    process of caching the result of a thunk is memoization

- **traversable functors**

    ```scala
    def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]

    def sequence[G[_]: Applicative, A](fga: F[G[A]]): G[F[A]]
    ```
    - traverse looks similar to `flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]` but `f`
    returns a `G[B]` and the result is `G[F[B]]`
    - sequence reverses F & G