#!/bin/bash

BASEDIR=~/.services/dubbodemo
SERVICES_START=("user")
SERVICES_STOP=("user")

start()
{
    local services=($@)
    local s
    for s in ${services[@]}
    do
        service="$s-service"
        script_path=$BASEDIR/$service/bin/$service
        log_path=$BASEDIR/$service/wrapper.log
        if [ -f $script_path ]
        then
            $script_path start
            if [ "$?" != "0" ]
            then
                echo "Start $service failed:"
                echo `cat $log_path`
                exit 1
            else
                sleep 20
                echo "Start $service successfully."
            fi
        else
            echo "$script_path doesn't exist, please check."
            exit 1
        fi
    done
}

stop()
{
    local services=($@)
    local s
    for s in ${services[@]}
    do
        service="$s-service"
        script_path=$BASEDIR/$service/bin/$service
        if [ -f $script_path ]
        then
            $script_path stop
        else
            echo "$script_path doesn't exist, please check."
            exit 1
        fi
    done
}

restart()
{
    local services=($@)
    local s
    for s in ${services[@]}
    do
        service="$s-service"
        script_path=$BASEDIR/$service/bin/$service
        if [ -f $script_path ]
        then
            $script_path restart
        else
            echo "$script_path doesn't exist, please check."
            exit 1
        fi
    done
}

args=($@)

case "$1" in

    'start')
        if [ "$2" == "" ]
        then
            ss=${SERVICES_START[@]}
        else
            ss=${args[@]:1:100}
        fi
        start ${ss[@]}
        ;;

    'stop')
        if [ "$2" == "" ]
        then
            ss=${SERVICES_STOP[@]}
        else
            ss=${args[@]:1:100}
        fi
        stop ${ss[@]}
        ;;

    'restart')
        if [ "$2" == "" ]
        then
            ss=${SERVICES_STOP[@]}
        else
            ss=${args[@]:1:100}
        fi
        restart ${ss[@]}
        ;;
    *)
        echo "Usage: $0 { start | stop | restart }"
        exit 1
        ;;
esac

exit 0
