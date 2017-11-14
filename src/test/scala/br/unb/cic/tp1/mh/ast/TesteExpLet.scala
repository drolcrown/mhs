package br.unb.cic.tp1.mh.ast

import org.scalatest._


class TesteExpLet extends FlatSpec with Matchers {

  "A let x = 10 in x + x" should "be evaluated to Valor(20)" in {
    val let  = new ExpLet("x", ValorInteiro(10),
      new ExpSoma(new ExpRef("x"), new ExpRef("x")))


    let.avaliar() should be (ValorInteiro(20))
  }

}
