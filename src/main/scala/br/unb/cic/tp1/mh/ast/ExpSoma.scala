package br.unb.cic.tp1.mh.ast

class ExpSoma(lhs : Expressao, rhs : Expressao) extends ExpBinaria(lhs, rhs) {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor + v2.valor)
  }
}
