package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.exceptions.TipoInvalido
import br.unb.cic.tp1.mh.memoria.Ambiente

class ExpAplicacaoNomeada(val nome: String, argumentoAtual : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val decFuncao = Ambiente.recuperarFuncao(nome)
    Ambiente.novoAmbiente()
    Ambiente.atualiza(decFuncao.argFormal, argumentoAtual.avaliar())
    if(decFuncao.corpo.verificaTipo == argumentoAtual.verificaTipo) {
      val res = decFuncao.corpo.avaliar()
      Ambiente.removeAmbiente()
      return res
    }else {
      throw TipoInvalido()
    }
  }

  override def verificaTipo: Tipo = {
    if(this.avaliar().verificaTipo == argumentoAtual.verificaTipo) {
      argumentoAtual.verificaTipo
    }
    else {
      TErro()
    }
  }
}
