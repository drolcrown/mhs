package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

class ExpRef(val variavel : String) extends Expressao{

  override def avaliar(): Valor = Ambiente.consulta(variavel)

}
