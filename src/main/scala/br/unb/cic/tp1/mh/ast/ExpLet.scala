package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

class ExpLet(val id : String, val expNomeada : Expressao, val corpo : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val valor = expNomeada.avaliar() // innermost strategy
    Ambiente.atualiza(id, valor)

    return corpo.avaliar()
  }

  override def verificaTipo: Tipo = {
    if(expNomeada.verificaTipo == corpo.verificaTipo) {
      expNomeada.verificaTipo
    }
    else {
      TErro()
    }
  }

}
