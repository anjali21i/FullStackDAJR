import PropTypes from 'prop-types'
import React from 'react'
import { connect } from 'react-redux'

export const RootComponent = (props) => {
    return (
        <div>RootComponent</div>
    )
}

RootComponent.propTypes = {
    second: PropTypes.third
}

const mapStateToProps = (state) => ({})

const mapDispatchToProps = {}

export default connect(mapStateToProps, mapDispatchToProps)(RootComponent)