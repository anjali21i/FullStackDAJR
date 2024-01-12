import React from 'react';
import ReactDOMServer from 'react-dom/server';
// import mbreducer from '../../store/reducers/MasterReducer';
import {Provider} from "react-redux";
// import {legacy_createStore} from "redux";

import { reducerKeys } from './Redux/slices/ReducerList';
import { configureStore } from '@reduxjs/toolkit';
import { getStoreConfig } from './Redux/store/storeConfig';
import serializeJavascript from 'serialize-javascript';
import { PROJECT_ID_MAP } from './utils';
import RootComponent from './RootComponent';


global.render = (template, componentName, serverSideState) => {
    const initialState = JSON.parse(serverSideState);
    const preloadedState = {
        [reducerKeys.userInfoData]: initialState.userData,
        [reducerKeys.userPackages]: initialState.userPackages,
        [reducerKeys.isCsr]: "false"
    };
    // const store1 = legacy_createStore (
    //     mbreducer, initialState
    // );
    const store = configureStore(getStoreConfig(preloadedState));
    
    const ssrReactComponent = (
        <React.Fragment>
            <Provider store={store}>
                <RootComponent />
            </Provider>
        </React.Fragment>
    )
    const serverSideContent = ReactDOMServer.renderToString(ssrReactComponent);
   

    const normalisedComponentName = componentName.replace(/-/g, "_");
    normalisedComponentName = PROJECT_ID_MAP.USER_DASHBOARD;
    return template
        .replace(new RegExp(/{COMPONENT_NAME}/g), normalisedComponentName)
        .replace('{SERVER_RENDERED_HTML}', serverSideContent)
        .replace('{SERVER_RENDERED_STATE}', serializeJavascript(initialState, {isJSON: true}));
    
};