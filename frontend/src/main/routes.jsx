import React from 'react'
import { Router, Route, Redirect, hashHistory } from 'react-router'

import Cidade from '../cidade/cidade'
import About from '../about/about'

export default props => (
    <Router history={hashHistory}>
        <Router path='/cidades' component={Cidade} />
        <Router path='/about' component={About} />
        <Redirect from='*' to='/cidades' />
    </Router>
)