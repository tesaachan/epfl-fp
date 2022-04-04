trait LIST[T]:
    def isEmpty: Boolean
    def head: T
    def tail: LIST[T]

class CONS[T](val head: T, val tail: LIST[T]) extends LIST[T]:
    def isEmpty = false

class NIL[T] extends LIST[T]:
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")

def singleton[T](elem: T) = CONS[T](elem, NIL[T])

def nth[T](xs: LIST[T], n: Int): T =
    if xs.isEmpty then throw new IndexOutOfBoundsException()
    else if n == 0 then xs.head
    else nth(xs.tail, n - 1)

val a = nth(CONS(1, CONS(2, CONS(3, NIL()))), 2)
