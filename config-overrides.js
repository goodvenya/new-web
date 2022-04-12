const { override, adjustStyleLoaders } = require('customize-cra');

module.exports = override(
  (config) => {
    const plugin = config.plugins.find(
      (_plugin) => _plugin.constructor.name === 'MiniCssExtractPlugin',
    );

    if (plugin) plugin.options.ignoreOrder = true;

    return config;
  },
  adjustStyleLoaders(({ use: [, css] }) => {
    if (!css.options.modules) css.options.modules = {};
    css.options.modules.exportLocalsConvention = 'camelCase';
  }),
);
