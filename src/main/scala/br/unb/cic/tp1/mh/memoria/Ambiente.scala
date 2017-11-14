package br.unb.cic.tp1.mh.memoria

import br.unb.cic.tp1.mh.ast.Valor

import scala.collection.mutable

object Ambiente {

  val tabela = new mutable.HashMap[String, Valor]

  def atualiza(variavel : String, valor : Valor): Unit = {
    tabela += (variavel -> valor)
  }

  def consulta(variavel : String) = tabela(variavel)
}
