'''
Created on Jul 10, 2015

@author: sgee
'''
import io, sys, getopt

EXIT_SUCCESS = 0
EXIT_BAD_ARGS = 1

class SCM(object):
    def main(self, argv):
        version_file = open('__version__.py', 'r')
        tmp_version = version_file.read()
        version_file.close()
        print tmp_version
        keys = tmp_version.split("\"")
        version = keys[1]
        
        print 'Current Version: ', version
        sys.exit(0)
        keys = version.split('.')
        major_version = int(keys[0])
        secondary_version = int(keys[1])
        tertiary_version = int(keys[2])
        print 'major_version: ',major_version
        print 'secondary_version: ',secondary_version
        print 'tertiary_version: ',tertiary_version
            
        self.parse_arguments(argv)
# -- move this to the arg code block                
        try:   
            NOPE ...
            
            options, args = getopt.getopt(argv, 'hmstr:', ['set'])
            for opt, arg in options:
                if opt in ('-m', '--major'):
                    print 'Incrementing Major'
                    major_version = major_version + 1
                elif opt in ('-s', '--secondary'):
                    print 'Incrementing Secondary'
                    secondary_version = secondary_version + 1
                elif opt in ('-t', '--tertiary'):
                    print 'Incrementing Tertiary'
                    tertiary_version = tertiary_version + 1
                elif opt in ('-r'):
                    clr = list(arg)
                    for rclr in clr:
                        print 'Reset: ', rclr
                        if rclr == 'm':
                            major_version = 0
                        elif rclr == 's':
                            secondary_version = 0
                        elif rclr == 't':
                            tertiary_version = 0
            NOPE ...            
            #end for            
        except getopt.GetoptError:
            print 'update_version.py -m -s -t -r[mst]'
            print '\t-m Increment Master Version'
            print '\t-s Increment Secondary Version'
            print '\t-t Increment Tertiary Version'
            print '\t-rmst Reset [m] Master [s] Secondary [t] Tertiary Versions'
            sys.exit(2)              
        #end try-catch

        print ('major_version: %s' % major_version)
        print ('secondary_version: %s' % secondary_version)
        print ('tertiary_version: %s' % tertiary_version)
        
        version = ('%s.%s.%s' % (major_version,secondary_version,tertiary_version)) #str(major_version) + '.' + str(secondary_version) + '.' + str(tertiary_version)
        version_file = open('__version__.py', 'w')
        version_file.write('__version__=\"' + version + '\"')
        version_file.close()
        
        sys.exit(EXIT_SUCCESS)
    #end main
    
    def parse_arguments(self, argv):
        global update_major
        global update_secondary
        global update_tertiary
        global reset_master
        global reset_secondary
        global reset_tertiary
        
        update_major = False
        update_secondary = False
        update_tertiary = False
        reset_master = False
        reset_secondary = False
        reset_tertiary = False
        
        
        
        try:   
            options, args = getopt.getopt(argv, 'hmstr:', ['set'])
            for opt, arg in options:
                if opt in ('-m', '--major'):
                    print 'Incrementing Major'
                    major_version = major_version + 1
                elif opt in ('-s', '--secondary'):
                    print 'Incrementing Secondary'
                    secondary_version = secondary_version + 1
                elif opt in ('-t', '--tertiary'):
                    print 'Incrementing Tertiary'
                    tertiary_version = tertiary_version + 1
                elif opt in ('-r'):
                    clr = list(arg)
                    for rclr in clr:
                        print 'Reset: ', rclr
                        if rclr == 'm':
                            major_version = 0
                        elif rclr == 's':
                            secondary_version = 0
                        elif rclr == 't':
                            tertiary_version = 0
                        
            #end for            
        except getopt.GetoptError:
            print 'update_version.py -m -s -t -r[mst]'
            print '\t-m Increment Master Version'
            print '\t-s Increment Secondary Version'
            print '\t-t Increment Tertiary Version'
            print '\t-rmst Reset [m] Master [s] Secondary [t] Tertiary Versions'
            sys.exit(EXIT_BAD_ARGS)
        #end try-catch

if __name__ == '__main__':
    SCM.main(sys.argv[1:])    #main(sys.argv[1:])
