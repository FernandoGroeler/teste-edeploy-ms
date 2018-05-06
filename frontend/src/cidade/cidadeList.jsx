import React from 'react'
import { connect } from 'react-redux'
import IconButton from '../template/iconButton'
import { bindActionCreators } from 'redux'
import { showScore } from './cidadeActions'

const CidadeList = props => {
    const renderRows = () => {
        const list = props.list || []
        return list.map(cidade => (
            <tr key={cidade.id}>
                <td>{cidade.id}</td>
                <td>{cidade.nome}</td>
                <td>{cidade.estado}</td>
                <td>
                    <IconButton style='success' text='Ver pontuação' onClick={() => props.showScore(cidade)}></IconButton>
                </td>
            </tr>
        ))
    }

    return (
        <table className='table'>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Estado</th>
                    <th className='tableActions'>Pontuação</th>
                </tr>
            </thead>
            <tbody>
                {renderRows()}
            </tbody>
        </table>
    )
}

const mapStateToProps = state => ({list: state.cidade.list})
const mapDispatchToProps = dispatch => bindActionCreators({ showScore }, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(CidadeList)