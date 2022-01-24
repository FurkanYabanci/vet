
# Spring Boot and Thymeleaf Application

Veteriner Uygulaması

  
# Özet

Bu proje evcil hayvan ve hayvan sahiplerinin sisteme kaydedilerek,sistemde tutulmasını sağlar..

# Gereksinimler

• Hayvan sahibinin kaydı için gerekli endpointler (name, surname, address, phone number, email)

• İstenilen hayvan sahibine, evcil hayvan kaydı yapmak için gerekli endpointler (name, type, species ,age , explanation, pet owner id)

• Girilen endpointlerden phone number 11 haneli olmalı, email gerekli validation kurallarına göre yazılmalı, age 0'dan küçük olmamalıdır.


   Uygulama 2 API içerir
  
• PetOwnerAPI

• PetAPI

  GET /v1/petOwner/getAll - Tüm hayvan sahiplerini getirir.
  
  GET /v1/pet/findPetByPetOwnerId(petOwnerId={petOwner.id}) - Evcil hayvanları,hayvan sahibi id sine göre getirir.
  
  GET /v1/petOwner/createPetOwnerForm - Hayvan sahiplerinin kayıt formunu getirir.
  
  GET /v1/pet/createPetForm - Evcil hayvan kayıt formunu getirir.

  POST /v1/petOwner/createPetOwner - Hayvan sahiplerini sisteme kaydeder.
  
  POST /v1/pet/createPet - Evcil hayvanları sisteme kaydeder.

# Teknolojiler

• Java 11

• Spring Boot

• Spring Data JPA

• Restful API 

• H2 In memory database

• Docker

• Thymeleaf for frontend

# Önkoşullar

• Maven

• Docker

# Çalıştırma

  Docker
  
  Sadece docker run -t vet-0.1.jar komutunu çalıştırmanız yeterlidir.
  
  *$Port: 8087*
  ```ssh
  $ cd /vet
  $ docker run -t vet-0.1.jar
  ```
  
