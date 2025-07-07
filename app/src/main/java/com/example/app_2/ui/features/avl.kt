package com.example.app_2.ui.features
/*
class NodoAvl(var id: Int, var nombre: String) {
    var izq: NodoAvl? = null
    var der: NodoAvl? = null
    var altura: Int = 1
}

class Avl {
    var raiz: NodoAvl? = null

    fun Insertar(id: Int, nombre: String) {
        raiz = InsertarRecurcibo(raiz, id, nombre)
    }

    fun InsertarRecurcibo(nodo: NodoAvl?, id: Int, nombre: String): NodoAvl {
        if (nodo == null) {
            return NodoAvl(id, nombre)
        } else if (id < nodo.id) {
            nodo.izq = InsertarRecurcibo(nodo.izq, id, nombre)
        } else if (id > nodo.id) {
            nodo.der = InsertarRecurcibo(nodo.der, id, nombre)
        } else {
            return nodo
        }
        actualizaraltura(nodo)
        return Balancear(nodo)
    }

    fun actualizaraltura(nodo: NodoAvl) {
        nodo.altura = 1 + maxOf(altura(nodo.izq), altura(nodo.der))
    }


    fun altura(nodo: NodoAvl?): Int {
        if (nodo == null) {
            return 0
        } else {
            return nodo.altura
        }
    }

    fun BalanceFactor(nodo: NodoAvl): Int {
        return altura(nodo.izq) - altura(nodo.der)
    }

    fun RotarDerecha(y: NodoAvl): NodoAvl {
        val x = y.izq!!
        val T2 = x.der

        x.der = y
        y.izq = T2

        actualizaraltura(y)
        actualizaraltura(x)

        return x
    }

    fun RotarIzquierda(x: NodoAvl): NodoAvl {
        val y = x.der!!
        val T2 = y.izq

        y.izq = x
        x.der = T2

        actualizaraltura(x)
        actualizaraltura(y)

        return y
    }


    fun Balancear(nodo: NodoAvl): NodoAvl {
        val balance = BalanceFactor(nodo)

        if (balance > 1 && BalanceFactor(nodo.izq!!) < 0) {
            return RotarDerecha(nodo)
        }
        if (balance > 1 && BalanceFactor(nodo.izq!!) < 0) {
            nodo.izq = RotarIzquierda(nodo.izq!!)
            return RotarDerecha(nodo)
        }
        if (balance < -1 && BalanceFactor(nodo.der!!) <= 0) {
            return RotarIzquierda(nodo)
        }
        if (balance < -1 && BalanceFactor(nodo.der!!) > 0) {
            nodo.der = RotarDerecha(nodo.der!!)
            return RotarIzquierda(nodo)
        }

        return nodo
    }

}
*/
//tarea sebastian hacer una lista enlasada con recursion en kotlin

class Nodo() {
    var v: Int? = null
    var next: Nodo? = null
}

fun add(nodo: Nodo?) {

}
fun show(nodo:Nodo?){

    print(nodo!!.v)
    if (nodo == null) {
        println("no hay nada en la lista")
    }
    if(nodo.next != null){
        show(nodo.next)
    }
    print("final del la lista")
}

fun main() {
    var head: Nodo? = null
    show(head)


}