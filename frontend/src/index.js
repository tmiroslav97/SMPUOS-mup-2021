import React from 'react';
import ReactDOM from 'react-dom';
import { Router } from 'react-router-dom';
import { createBrowserHistory } from 'history';
import AppRouter from './AppRouter';

export const history = createBrowserHistory();

ReactDOM.render(
  <Router history={history}>
    <AppRouter />
  </Router>,
  document.getElementById('root')
);

