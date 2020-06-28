import React from 'react'

function PersonList({persons}){
const personList=persons.map(person => <h4>Hello {person.name}. I am {person.age} years old.</h4>)
    return (
        <div>
           {personList}
        </div>
    )
}
