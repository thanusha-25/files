import React,{Component} from 'react';

class Message extends Component
{
    constructor()
    {
        super()
        this.state = {
            message :'Hello Welcome'
        }

       // this.getSubscribe =this.getSubscribe.bind(this)
    }

    
getSubscribe () {
    this.setState({
                message:'Thanks for subscription'
            })
            console.log("clicked....!!!")

}

    render(){
        return(
          <div>
            <h1>{this.state.message}</h1>
        <button onClick={ this.getSubscribe.bind(this)}>Subscribe</button>
           </div>
        );
        }
 }

 export default Message
