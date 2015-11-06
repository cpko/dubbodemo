#!/usr/bin/env python
# -*- coding: utf-8 -*-
__author__ = 'cpk'

from os.path import expanduser
from fabric.api import *


@task
def build(*args, **kwargs):
    project_dir = expanduser("~") + "/openSource/dubbodemo"

    services = ["user"]
    service = '%s-service'
    log_dir = '%s/target/jsw/%s/logs'
    script_dir = '%s/target/jsw/%s/bin/*'
    service_dir = '%s/target/jsw/%s/'
    cache_dir = expanduser('~') + "/.services/dubbodemo/"
    profile = 'prod'

    if kwargs.get('env') is not None:
        profile = kwargs.get('env')

    with lcd(project_dir):
        local('mvn clean package -U -Dmaven.test.skip -P%s' % profile)

        for _s in services:
            s = service % _s
            local(u'mkdir -p {}'.format(log_dir % (_s, s)))
            local(u'chmod +x {}'.format(script_dir % (_s, s)))
            local(u'rsync -rv --delete {} {}{}/'.format(service_dir % (_s, s), cache_dir, s))
            local(u'open %s' % cache_dir)