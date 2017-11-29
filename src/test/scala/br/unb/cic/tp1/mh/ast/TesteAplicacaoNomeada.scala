package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import org.scalatest._

class TesteAplicacaoNomeada  extends FlatSpec with Matchers {

  behavior of "a named function def inc (x) = x + 1"

  it should "be evaluated to 16 when inc 15 " in {
    val inc = new DecFuncao("inc", "x", ExpSoma(ExpRef("x"), ValorInteiro(1)))

    Ambiente.declararFuncao(inc)

    val app = new ExpAplicacaoNomeada("inc", ExpSoma(ValorInteiro(5), ValorInteiro(10)))

    app.avaliar() should be (ValorInteiro(16))

  }
}
