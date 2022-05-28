@US1001
Feature: US1001_a_harfindeki_magazalaari_yazdir

  @US1001TC01
  Scenario:Kullanici n11 adresine gider ve istenen harf ile baslayan magaza isimlerini istenen dosya formatinda yazdirir
    Given Kullanici "n11" adresine gider
    Then Ana sayfada magazalar menusunun uzerine gelir
    And  Magazalar menusunden magazalari gor secenegine tiklar
    And  Acilan magazalar sayfasinda tum magazalar butonuna tiklar
    Then  A ile baslayan tum magazalari yazdirir