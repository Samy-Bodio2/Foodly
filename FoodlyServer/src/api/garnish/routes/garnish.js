'use strict';

/**
 * garnish router
 */

const { createCoreRouter } = require('@strapi/strapi').factories;

module.exports = createCoreRouter('api::garnish.garnish');
