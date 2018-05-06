import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'

import Grid from '../template/grid'
import IconButton from '../template/iconButton'
import { changeNome, changeEstado, search, clear } from './cidadeActions'

class CidadeForm extends Component {
    constructor(props) {
        super(props)
    }

    componentWillMount() {
        this.props.search()
    }

    render() {
        const { search, id, nome, estado } = this.props

        return (
            <div role='form' className='cidadeForm'>
                <Grid cols='12 9 10'>
                    <input id='nome' className='form-control' 
                        placeholder='Pesquisar por nome' 
                        onChange={this.props.changeNome} 
                        value={this.props.nome}></input><br/>
                    <input id='estado' className='form-control' 
                        placeholder='Pesquisar por estado' 
                        onChange={this.props.changeEstado} 
                        value={this.props.estado}></input><br/>
                </Grid>    
                <Grid cols='12 3 2'>
                    <IconButton style='info' icon='search' onClick={search}></IconButton>
                    <IconButton style='default' icon='close' onClick={this.props.clear}></IconButton>            
                </Grid>
            </div>
        )
    }
}

const mapStateToProps = state => ({id: state.cidade.id, nome: state.cidade.nome, estado: state.cidade.estado})
const mapDispatchToProps = dispatch => bindActionCreators({ changeNome, changeEstado, search, clear }, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(CidadeForm)