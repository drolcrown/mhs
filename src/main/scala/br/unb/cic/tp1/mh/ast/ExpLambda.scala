package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

import scala.collection.mutable

class ExpLambda(val id : String, val corpo: Expressao) extends Expressao {

  override def avaliar(): Valor = {
     return Closure(id, corpo, Ambiente.ambienteAtual())
  }


  override def verificaTipo: Tipo = {
    return avaliar().verificaTipo
  }
  
}
