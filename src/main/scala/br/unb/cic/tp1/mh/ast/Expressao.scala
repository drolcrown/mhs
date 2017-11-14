package br.unb.cic.tp1.mh.ast

trait Expressao {
  def avaliar() : Valor
}

abstract class ExpBinaria(val lhs : Expressao, val rhs : Expressao)
  extends Expressao