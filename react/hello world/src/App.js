import React, { Component } from 'react';
import './App.css';
import Greet from './components/Greet';
import Welcome from './components/Welcome';
import Hello from './components/Hello';
import Message from './components/Message';
import Counter from './components/Counter';
import ParentComponent from './components/ParentComponent'
import ChildComponent from './components/ChildComponent'
import Conditional from './components/Conditional';
import Person from './components/Person';
class App extends Component {
  render() {
    return (
      <div>
         {/* <Greet name="Vihan"/>
         <Welcome name="Tillu"/> */}
        {/* <Hello />  */}
        {/* <Message /> */}
        {/* <Counter /> */}
        {/* <ParentComponent /> */}
       {/* <Conditional /> */}
       <Person />
         </div>
    );
  }
}

export default App;
