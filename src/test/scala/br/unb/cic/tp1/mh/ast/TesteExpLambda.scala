package br.unb.cic.tp1.mh.ast

import org.scalatest._

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException

class TesteExpLambda extends FlatSpec with Matchers {

  behavior of "a lambda expression"
  
  it should "be evaluated to Closure(x, x+1) when (x) -> x + 1" in {
    val inc  = new ExpLambda("x", 
      new ExpSoma(new ExpRef("x"), ValorInteiro(1)))


    inc.avaliar() should be (Closure("x", new ExpSoma(new ExpRef("x"), ValorInteiro(1))))
  }

}
