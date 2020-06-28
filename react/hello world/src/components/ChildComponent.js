import React,{Component} from 'react'

class ChildComponent extends Component
{
   render(){
       return(
           <div>
               <button onClick = {() => <div>{this.props.name('child')}</div>}> Click</button>
           </div>
       )
   }

}

export default ChildComponent