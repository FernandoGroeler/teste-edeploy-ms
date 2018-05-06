import React from 'react'

import PageHeader from '../template/pageHeader'
import CidadeForm from './cidadeForm'
import CidadeList from './cidadeList'

export default props => (
    <div>
        <PageHeader name='Cidades'></PageHeader>
        <CidadeForm />
        <CidadeList />
    </div>
)