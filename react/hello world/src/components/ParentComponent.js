import React,{Component} from 'react'
import ChildComponent from './ChildComponent'

class ParentComponent extends Component
{

   constructor(props)
   {
       super(props)
       this.state={
           ParentName : 'parent'
       }

       this.getParentName=this.getParentName.bind(this)
   }

  getParentName(childName)
  {
   alert("hello "+this.state.ParentName +" from "+childName)
  }

    render(){
        return(
            <div>
              <ChildComponent name={this.getParentName} />
            </div>
        )
    }
}

export default ParentComponent