package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteAplicacaoLambda extends FlatSpec with Matchers {

  behavior of "an application of a lambda expression"
  
  it should "be evaluated to Valor(6) when ((x) -> x + 1) 5)" in {
    val inc = new ExpLambda("x", new ExpSoma(new ExpRef("x"), ValorInteiro(1)))
    val app = new ExpAplicacaoLambda(inc, ValorInteiro(5)) 

    app.avaliar() should be (ValorInteiro(10))
  }

}
