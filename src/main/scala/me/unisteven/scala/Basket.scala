package me.unisteven.scala

class Basket[T] {
  private var item: T = null.asInstanceOf[T] // this is the way to intialize the variable

  def setItem(item: T): Unit ={
    this.item = item
  }

  def getItem(): T ={
    this.item
  }
}
