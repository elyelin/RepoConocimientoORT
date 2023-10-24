
// Obtiene tipo de dato
console.log(typeof x)

if (true){
    var ambito = "Esta variable estara disponible hasta el final del codigo y/o script en donde se este ejecutando"  
  }
  
  if (true){
    let blockscoped = "Esta variable estata solo disponible dentro de este bloque de control"
    console.log("blockscoped:", blockscoped)
  
    const otroBlock = "Esta constante tampoco estara disponible de forma global"
    console.log("otroBlock: ", otroBlock)
  }

  // Esto copia o1 en o3 (sin referencia)
const o3 = Object.assign({}, o1)

//OBJETOS MUTABLES
function deepCopy(obj) {
    // verifica si los valores son objetos
    // Si son objetos copio ese objeto a sí mismo
    // Sino retorno el valor
    const keys = Object.keys(obj)
  
    //console.log(keys)
  
    const newObject = {}
  
    for (let i = 0; i < keys.length; i++) {    
      const key = keys[i]
      
      if (typeof obj[key] === 'object') {
        newObject[key] = deepCopy(obj[key])
      } else {
        newObject[key] = obj[key]
      }
    }
  
    //console.log("debe retornar", newObject)
  
    return newObject
  }
  //OBJETOS
  const objeto3 = {
    firstName : "Daniel",
    lastName : "Guzman",
    saludo: function (nombre){
      console.log(`Hola ${nombre}, un gusto saludarte`)
    },
    direccion: {
      calle: 'Av. Libertador',
      numro: 6700
    }
  }

  //delete o.class // Eliminamos atributos de un Objeto JavaScript
  /// Convierte un objeto a cadeno 
let cadena_objeto  = JSON.stringify(o)
//console.log(typeof cadena_objeto, cadena_objeto)

// Convertimos una cadena a objeto
cadena_objeto = JSON.parse(cadena_objeto)
//console.log(typeof cadena_objeto, cadena_objeto)

  function saludo(nombre){
    console.log(`Hola ${nombre}`)
    // console.log('Hola '+ nombre)
  }

  //HOISTING
  const noFunction = function(){
    console.log("Esta funcion no es tomada en cuenta por el mecanismo hoisting")
  }
  const otraFunction = () => console.log("Otra funcion que no es tomada en cuenta con el mecanismo hoisting")

  //COERCION DE DATOS
  const x = 17
const explicito = String(x) // explicito === "17"
const implicito = x + ""
console.log("implicito", typeof  implicito, implicito)