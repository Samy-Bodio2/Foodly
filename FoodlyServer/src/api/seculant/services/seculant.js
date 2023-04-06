'use strict';

/**
 * seculant service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::seculant.seculant');
