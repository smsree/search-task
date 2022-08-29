import logo from './logo.svg';
import './App.css';
import { useState,useRef,useEffect } from 'react';
import axios from 'axios';

function App() {
  const[name,setName]=useState([])
  const[enterName,setEnteredName]=useState()
  
  

  const fetchHander=(event)=>{
    event.preventDefault();
    setEnteredName(event.target.value)
    axios.get("http://localhost:8100/book/"+enterName)
      .then(res=>setName(res.data))
      .catch(err=>console.log(err))
    
  }

  

  return (
    <div className="App">
      <label id='search'>Search Bar</label><br/>
     <input type="text" id="search" placeholder="Enter book title" onChange={fetchHander} />
     {name.map(data=><p>{data.title}</p>)}
    </div>
  );
}

export default App;
