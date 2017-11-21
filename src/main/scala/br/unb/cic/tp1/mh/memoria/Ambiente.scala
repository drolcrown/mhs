package br.unb.cic.tp1.mh.memoria

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.ast.Valor

import scala.collection.mutable

object Ambiente {

  val stack = new mutable.Stack[mutable.HashMap[String, Valor]]()

  def atualiza(variavel : String, valor : Valor): Unit = {
    if(stack.isEmpty) {
      stack.push(new mutable.HashMap[String, Valor])
    }
    stack.top += (variavel -> valor)
  }

  def consulta(variavel : String) : Valor = {
    if(!stack.isEmpty) {
      return stack.top(variavel)
    }
    throw VariavelNaoDeclaradaException()
  }

  def novoAmbiente(ambiente: mutable.HashMap[String, Valor]): Unit = {
    stack.push(ambiente)
  }
  def ambienteAtual() : mutable.HashMap[String, Valor] = {
    if (stack.isEmpty) {
      stack.push(new mutable.HashMap[String, Valor]())
    }
    return stack.top
  }

  def removeAmbiente(): Unit = {
    stack.pop()
  }
}
