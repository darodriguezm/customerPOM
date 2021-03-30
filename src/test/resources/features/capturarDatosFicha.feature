#Author: Daniel Rodríguez

@declaracion
Feature: Captura de ficha tecnica de producto
  Como cliente quiero seleccionar aleatoriamente cualquier producto resultante de la busqueda en sodimac.cl

  @acceso
  Scenario Outline: Navegar y revisar resultado de un producto de una busqueda
    Given quiero ingresar al portal de sodimac
    When realizo la busqueda de un tipo de <articulo>
    And ingreso a los detalles de un producto aleatorio del resultado
    Then validar que los campos del articulo seleccionado no sean nulos
    
    Examples:
    | articulo  |
    | resposera |