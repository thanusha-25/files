import react,{Component} from 'react'

class Conditional extends Component
{

    constructor()
    {
        super()
        this.state={
            isLoogedIn : true
        }
    }

//    render()
//    {
//        if(this.state.isLoogedIn)
//        return ("Welcome thanu")
//        else
//        return ("welcome Guest")
//    }


//   render()
//   {
//     let message 
//      if(this.state.isLoogedIn)
//      message ="Welcome thanu"
//      else
//      message ="Welcome Guest"
//      return message
//   }

// render()
// {
//     return( this.state.isLoogedIn ? "welcome thanu" : "Welcome guest")
// }

   render()
   {
       return this.state.isLoogedIn && "Welcome Thanu"
   }

} 

export default Conditional