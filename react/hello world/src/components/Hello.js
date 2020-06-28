import React from 'react';
const Hello=()=> {
    return React.createElement('div',{id: 'outer', className:'divClass'},React.createElement("h1",null,"JSX contents"))
}
export default Hello