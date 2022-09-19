import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Post from '../src/components/Post/Post';

ReactDOM.render(
  <React.StrictMode>
    <Post />
  </React.StrictMode>,
  document.getElementById('root')
)

reportWebVitals();
