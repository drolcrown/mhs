package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

import br.unb.cic.tp1.exceptions.ExpressaoInvalida

case class ExpAplicacaoLambda(exp1 : Expressao, exp2 : Expressao) extends Expressao { 

  override def avaliar(): Valor = {
    val v1 = exp1.avaliar()

    v1 match {
      case Closure(v, c, ambiente) => {
        Ambiente.novoAmbiente(ambiente)
        Ambiente.atualiza(v, exp2.avaliar())
	      val res =  c.avaliar()
        Ambiente.removeAmbiente()
        return res
      }
      
      case _             => throw ExpressaoInvalida()
    } 
  }
  
}
