/**
 * Hacer una funcion que dado un array de participantes del curso me devuelva el alumno con mayor edad.
 *
 * [
 *  {
 *    firstName,
 *    lastName,
 *    age
 *  },
 *  ...,
 *  n
 * ]
 */

const participantes = [
  {
    firstName: "elye",
    lastName: "egff",
    age: 20,
  },
  {
    firstName: "maria",
    lastName: "mr",
    age: 26,
  },
  {
    firstName: "jose",
    lastName: "js",
    age: 33,
  },
];
console.log(participantes);

function participanteMayorEdad(arr) {
  let objetoEncontrado;

  for (let i = 0; i < arr.length; i++) {
    const element = arr[i];
    const secord = arr[i].age++;

    if (element.age > secord) {
      objetoEncontrado = element;
     //  console.log(objetoEncontrado.age);
    }
    //console.log(objetoEncontrado);
  }

  return objetoEncontrado;
}

console.log(participanteMayorEdad(participantes));
/**
     * var filtrados = participantes.filter(function(obtjt){
      return obtjt.age > 30
  })
  console.log(filtrados)
     */
