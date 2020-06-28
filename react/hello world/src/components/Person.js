import React from 'react'
import PersonList from './PersonList'
function Person()
{
    const persons=[
        {
            id :1,
            name :'thanu',
            age : 21
        },
        {
            id :2 ,
            name : 'hema',
            age :20
        }
    ]
    
       { const list=persons.map(person => (<div><PersonList person={person}/></div>)) }
    return(
        <div>
            {list}
        </div>
    )
}

export default Person