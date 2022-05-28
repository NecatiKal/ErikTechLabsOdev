@US1002
Feature: US1002_istenen_urunlerle_misafir_olarak_odeme_adimina_ilerleme

  @US1002TC01
  Scenario:Kullanici istenen urunleri istenen adette sepete ekler ve odeme adimina ilerler
    Given Kullanici "n11" adresine gider
    Then Ana sayfada arama kutusuna kulaklik yazar ve aratir
    And  Gelen sonuclari yorum sayisina gore siralar
    And  Gelen urunleri ucretsiz kargo secenegine gore filtreler
    Then  Gelen urunlerden ilk sayfadaki birinci ve sonuncu urunu sepete ekler
    And   Sepete gider ve sepetteki ucuz urunun adedini iki yapar
    Then  Misafir kullanici olarak odeme adimina ilerler