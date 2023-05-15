'use strict';

/**
 * garnish service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::garnish.garnish');
