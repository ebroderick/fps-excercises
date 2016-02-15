- **algebra** - abstract set of operations along with a set of laws or properties we assume to be
    true. in mathematical sense, one or more sets, together with a collection of functions
    operating on objects of these sets, and a set of axioms (statements assumed true from
    which we can derive other theorems that must also be true). From chp 7, sets are types
    like _Par[A]_ and _List[Par[A]]_, functions are operations like _map2_, _unit_, _sequence_

- **endofunction** - function where argument type and return type are the same. endo = within, "endofunction's codomain 
is within its domain."

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
    
- **product**
    - monoid example: if A and B are monoids, the tuple type (A, B) is their product and is also a monoid.
 
- **thunk** - unevaluated form of an expression. "force" the thunk to evaluate. ex type: _() => A_.
    process of caching the result of a thunk is memoization