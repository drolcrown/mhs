package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

import br.unb.cic.tp1.exceptions.ExpressaoInvalida

case class ExpAplicacaoLambda(exp1 : Expressao, exp2 : Expressao) extends Expressao { 

  override def avaliar(): Valor = {
    val v1 = exp1.avaliar()

    v1 match {
      case Closure(v, c) => {
        val v2 = exp2.avaliar()
	Ambiente.atualiza(v, v2)
	return c.avaliar()
      }
      
      case _             => throw ExpressaoInvalida()
    } 
  }
  
}
