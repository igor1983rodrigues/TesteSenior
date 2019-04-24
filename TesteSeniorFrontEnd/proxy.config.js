const proxy = [
    {
      context: '/api',
      target: 'http://localhost:8080/TesteSeniorBackend/api',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;