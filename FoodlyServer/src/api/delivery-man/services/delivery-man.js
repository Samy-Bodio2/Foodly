'use strict';

/**
 * delivery-man service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::delivery-man.delivery-man');
