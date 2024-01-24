openapi: 3.0.1
info: 
  title: Api de Consulta México
  description: Esta api permite realizar consultas sobre los Estados, Municipios, Codigos postales y Colonias
  version: 1.0.0
servers:
   - url: http://localhost:8081/api/v1
   
tags: 
- name: estados
  description: Este endpoint permite consultar la informacion sobre los estados
- name: municipios
  description: Este endpoint permite consultar la informacion sobre los municipios
- name: colonias
  description: Este endpoint permite consultar la informacion sobre las colonias
  
paths:
 **/estados**:
  get:
   tags: 
     - estados
   summary: Obtiene un listado de todos los estados
   responses: 
    200:
     description:  (OK) La consulta se realizó con exito
    404: 
     description: (NotFound) Estados no encontrados
     
     
 **/estado/{id_estado}:** 
    get: 
     tags: 
      - estados
     summary: Obtienes la informacion de un estado segun su id
     responses: 
      200:
        description:  (OK) La consulta se realizó con exito
     parameters: 
      - name: id_estado
        in: path
        description : es el id unico que le pertenece a cada estado
        required: true
  
 **/municipios/estado/{id_estado}:**
    get: 
     tags: 
      - municipios
     summary: Obtiene un listado de todos los municipios de un estado
    responses:
     200:
      description: (Ok) La consulta se realizó con exito
     404:
      description: (NotFound) No se encontraron municipios
   
    parameters: 
      - name: id_estado
        in: path
        description : es el id unico que le pertenece a cada estado
        required: true
        
 **/colonias/codigo_postal/{id}:**
   get: 
    tags: 
     - colonias
    summary: Obtiene un listado de colonias segun un codigo postal
    responses: 
     200: 
      description: (Ok) La consulta se realizó con exito
     404:
      description: (NotFound) No se encontraron municipios

    parameters: 
     - name: id
       in: path
       description: es el codigo postal de donde queremos obtener las colonias
       required: true
      
 **/municipio/{id_municipio}/estado/{id_estado}/colonias:**
  get: 
   tags: 
    - colonias
   summary: Obtiene un listado de todas las colonias de un municipio
   responses: 
    200: 
     description: (OK) La consulta se realizó con exito
    404:
      description: (NotFound) No se encontraron municipios

   parameters: 

    - name: id_municipio
      in: path
      description: es el id unico que le pertenece a cada municipio
      required: true

    - name: id_estado
      in: path
      description: es el id unico que le pertenece a cada estado
      required: true

-
     **Documentación en Postman:**
      [<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/31951901-bd2e9037-01c8-4eb7-8114-35b29f7d0ae0?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D31951901-bd2e9037-01c8-4eb7-8114-35b29f7d0ae0%26entityType%3Dcollection%26workspaceId%3D1a2d1444-3ef1-434a-8eec-e788192438ff)
