const path = require('path')
const { CleanWebpackPlugin } = require("clean-webpack-plugin")
const HtmlWebpackPlugin = require("html-webpack-plugin")

module.exports = () => [
    loadServerComponent('userdashboard', 'userdashboard', false),
    loadClientComponent('userdashboard', 'userdashboard', false, "")
]

const BASE_PATH = __dirname;
const OUTPUT_PATH = 'src/main/resources/public/generated';
const TARGET_SERVER = 'server';
const TARGET_CLIENT = 'client';

const loadClientComponent = (componentLocation, componentName, skipHashVer, chunkName) => {

    return {
        context: __dirname,
        entry: `/react-src/${componentLocation}/${componentName}-client.js`,
        output: {
            filename: `${componentLocation}/${componentName}.js`,
            path: path.resolve(__dirname, OUTPUT_PATH + '/' + TARGET_CLIENT),
            chunkFilename: `${componentLocation}/chunk-[name].${chunkName}client${skipHashVer ? "" : ".[chunkhash]"}.js`,
            publicPath: `/dashboardstatic/${new Date().getTime()}/client/`
        },
        resolve: {
            extensions: ['.js', '.jsx']
        },
        mode:'development',
        plugins: [
            // new CleanWebpackPlugin([TARGET_CLIENT], {
            //         root: BASE_PATH + '/' + OUTPUT_PATH
            //     }
            // ),
            new HtmlWebpackPlugin({
                inject: true,
                template: path.resolve(__dirname, OUTPUT_PATH + '/' + chunkName + 'index.html'),
                fileName: `${chunkName}index.html`,
            })
        ],
        module: {
            rules: [
                {
                    test: /\.js$/,
                    exclude: /node_modules/,
                    use: 'babel-loader'
                },
                {
                    test: /\.svg$/,
                    loader: 'null-loader'
                },
                {
                    test: /\.(ttf|eot|woff2?)$/,
                    loader: 'null-loader'
                }
            ]
        }
    }
}


const loadServerComponent = (componentLocation, componentName) => {

    return {
        context: __dirname,
        mode: 'development',
        entry: `/react-src/${componentLocation}/${componentName}-server.js`,
        output: {
            filename: `${componentLocation}/${componentName}.js`,
            path: path.resolve(__dirname, OUTPUT_PATH + '/' + TARGET_SERVER)
        },
        resolve: {
            extensions: ['.js', '.jsx']
        },
        // plugins: [
        //     new CleanWebpackPlugin([TARGET_SERVER], {
        //             root: BASE_PATH + '/' + OUTPUT_PATH
        //         }
        //     ),
        // ]
        module: {
            rules: [
                {
                    test: /\.js$/,
                    exclude: /node_modules/,
                    use: 'babel-loader'
                },
                {
                    test: /\.svg$/,
                    loader: 'null-loader'
                },
                {
                    test: /\.(ttf|eot|woff2?)$/,
                    loader: 'null-loader'
                }
            ]
        }

    }
}
